
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
            // Prevent the default form submission
            event.preventDefault();
            // Serialize the form data
            var formData = $("#calculationForm").serialize();
            // Send an AJAX POST request to the server
            $.ajax({
                type: "POST",
                url: "/calculate",
                data: formData,
                success: function (data) {
                    // Update the input field value with the result
                    $("#inputField").val(data);
                    // Fetch the updated history using AJAX
                    fetchHistory();
                }
            });
        }
        function fetchHistory() {
            // Send an AJAX GET request to retrieve the calculation history
            $.ajax({
                type: "POST",
                url: "/getHistory",
                success: function (data) {
                    // Update the history list
                    $("#historyList").empty();
                    data.forEach(function (entry) {
                        $("<li>").text(entry).appendTo("#historyList");
                    });
                }
            });
        }

        // Initial fetch of the history when the page loads
        fetchHistory();

