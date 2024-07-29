const stripe = Stripe('pk_test_51PHcNwP3y0uycL0QUtQrUz99u4zVMfn9VMABn2n1UpXybMAuxqfT9Q702N3oX8HyHinOjzpCgAtOksjsnvV2Hd8I0006OSSTQP');
 const paymentButton = document.querySelector('#paymentButton');
 
 paymentButton.addEventListener('click', () => {
   stripe.redirectToCheckout({
     sessionId: sessionId
   })
 });