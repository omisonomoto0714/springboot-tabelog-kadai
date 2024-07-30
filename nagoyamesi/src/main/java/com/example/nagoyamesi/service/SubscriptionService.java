package com.example.nagoyamesi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Subscription;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class SubscriptionService {
	@Value("${stripe.api-key}")
	private String stripeApiKey;

	public String createStripeSession(String paymentMethodId) {
		Stripe.apiKey = stripeApiKey;

		String priceId = "{{PRICE_ID}}";

		SessionCreateParams params = new SessionCreateParams.Builder()
				.setSuccessUrl("https://example.com/success.html?session_id={CHECKOUT_SESSION_ID}")
				.setCancelUrl("https://example.com/canceled.html")
				.setMode(SessionCreateParams.Mode.SUBSCRIPTION)
				.addLineItem(new SessionCreateParams.LineItem.Builder()
						// For metered billing, do not pass quantity
						.setQuantity(1L)
						.setPrice(priceId)
						.build())
				.build();

		try {
			Session session = Session.create(params);
		} catch (StripeException e) {
			e.printStackTrace();
		}
		return "redirect:/member";
	}

	public void cancelSubscription(Subscription subscription) {
		try {
			subscription.cancel();
		} catch (StripeException e) {
			e.printStackTrace();
		}
	}

}
