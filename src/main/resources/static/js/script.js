
        var inputField = document.getElementById('inputField');

        function appendInput() {
            var button = event.target;
            var value = button.getAttribute("data-value");
            var currentValue = inputField.value;
            inputField.value = currentValue + value;
        }
        function clearInput() {
            inputField.value = "";
        }
        function deleteInput() {
            var currentValue = inputField.value;
            inputField.value = currentValue.slice(0, -1);
        }
        function submitForm() {
            document.getElementById('calculationForm').submit();
        }

