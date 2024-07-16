function calculate(expression, priority) {
    const priorityMap = {
        '+': priority.indexOf('+'),
        '-': priority.indexOf('-'),
        '*': priority.indexOf('*')
    };

    const compute = {
        '+': (a, b) => a + b,
        '-': (a, b) => a - b,
        '*': (a, b) => a * b
    };

    const numbers = expression.split(/[\+\-\*]/).map(Number);
    const operators = expression.match(/[\+\-\*]/g) || [];

    while (operators.length > 0) {
        let maxPriority = Math.max(...operators.map(op => priorityMap[op]));
        let index = operators.findIndex(op => priorityMap[op] === maxPriority);

        numbers.splice(index, 2, compute[operators[index]](numbers[index], numbers[index + 1]));
        operators.splice(index, 1);
    }

    return Math.abs(numbers[0]);
}

function solution(expression) {
    const priorities = [
        ['+', '-', '*'],
        ['+', '*', '-'],
        ['-', '+', '*'],
        ['-', '*', '+'],
        ['*', '+', '-'],
        ['*', '-', '+']
    ];

    return Math.max(...priorities.map(priority => calculate(expression, priority)));
}