//package com.example.nagoyamesi.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.nagoyamesi.service.UserService;
//import com.stripe.exception.SignatureVerificationException;
//import com.stripe.model.Event;
//import com.stripe.model.checkout.Session;
//import com.stripe.net.Webhook;
//
//@RestController
//public class WebhookController {
//
//	@Value("${stripe.webhook-secret}")
//	private String endpointSecret;
//
//	private final UserService userService;
//
//	public WebhookController(UserService userService) {
//		this.userService = userService;
//	}
//
//	@Value("${stripe.api-key}")
//	private String stripeApiKey;
//
//	@PostMapping("/stripe/webhook")
//	public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload,
//			@RequestHeader("Stripe-Signature") String sigHeader) {
//		Event event;
//
//		try {
//			event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
//		} catch (SignatureVerificationException e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid signature");
//		}
//
//		// 決済が成功したとき
//		if ("checkout.session.completed".equals(event.getType())) {
//			handleCheckoutSessionCompleted(event);
//		}
//
//		return ResponseEntity.ok("");
//	}
//
//	private void handleCheckoutSessionCompleted(Event event) {
//		Session session = (Session) event.getDataObjectDeserializer().getObject().orElse(null);
//		if (session != null) {
//			String userId = session.getMetadata().get("userId");
//			if (userId != null) {
//				userService.upgradeRole(Integer.parseInt(userId));
//			}
//		}
//	}
//}
