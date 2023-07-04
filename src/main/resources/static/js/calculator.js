function appendValue(value) {
    var expression = document.getElementById('expression');
    expression.value += value;
}

function clearExpression() {
    var expression = document.getElementById('expression');
    expression.value = '';
}
