const imageInput = document.getElementById('imageFile');
const imagePreview = document.getElementById('imagePreview');

imageInput.addEventListener('change', () => {
	if(imageInput.files[0]) {
		let fileReader = new FileReader();
		fileReader.onload = () => {
			imagePreview.innerHTML = `<img src="${fileReader.result}" class="mb-3">`;
			
		}
		fileReader.readAsDataURL(imageInput.files[0]);
	} else {
		imagePreview.innerHTML = '';
	}
});

const lowestPriceInput = document.getElementById('lowestPrice');
const highestPriceInput = document.getElementById('highestPrice');
const errorMessage = document.getElementById('error-message');

function validatePrices() {
    const lowestPrice = parseFloat(lowestPriceInput.value);
    const highestPrice = parseFloat(highestPriceInput.value);

    if (!isNaN(lowestPrice) && !isNaN(highestPrice)) {
        if (lowestPrice > highestPrice) {
            errorMessage.textContent = '最低価格は最高価格よりも小さい値にしてください。';
        } else {
            errorMessage.textContent = ''; // エラーメッセージをクリア
        }
    }
}

lowestPriceInput.addEventListener('input', validatePrices);
highestPriceInput.addEventListener('input', validatePrices);
