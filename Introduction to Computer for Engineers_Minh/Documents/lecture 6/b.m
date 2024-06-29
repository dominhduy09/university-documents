clc

% Define the function
function y = f(x)
    y = x.^3 - 3*x + 1;
end

% Generate x values within the interval
x_values = linspace(-2, 2, 1000);

% Calculate corresponding y values
y_values = f(x_values);

% Plot the function
plot(x_values, y_values, 'LineWidth', 2);
grid on;
title('Nguyễn Đào Anh Khôi f(x) = x^3 - 3x + 1');
xlabel('x');
ylabel('f(x)');

