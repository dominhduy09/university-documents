clear all
close all
clc
% Step 1: Input the data points x and y
x = [0.1000 0.2000 0.3000 0.4000 0.5000 0.6000 0.7000 0.8000 0.9000 2.0000];
y = [8.1017 7.5913 7.5611 7.6671 7.1013 6.6660 6.5322 6.2011 6.4503 6.1714];

% Step 2: Plot the data points
figure;
plot(x, y, 'x--'); % Plot with red cross symbols
title('Curve fitting - Case choosing best fitting function');
xlabel('x values');
ylabel('y values');
grid on;
% Commenting the code
% This section computes linear and exponential fitting values for the given data points,
% calculates the sum of squared errors for each fitting, and plots the fitting functions on the same figure.

% Question 2.2: Linear fitting
% Step 1: Compute coefficients a11, a01 and save result into vector a1
a1 = polyfit(x, y, 1);

% Step 2: Computing fitting error
y_linear = a1(1)*x + a1(2);
soe1 = sum((y - y_linear).^2);

% Plotting linear fitting function
hold on;
plot(x, y_linear, '--b', 'LineWidth', 2);

% Question 2.3: Exponential fitting
% Step 1: Compute coefficients a12, a02 and save result into vector a2
a2 = polyfit(x, log(y), 1);
a2(1) = exp(a2(1)); % Update a12 as it's the coefficient of exponential term

% Step 2: Computing fitting error
y_exponential = a2(1) * exp(a2(2)*x);
soe2 = sum((y - y_exponential).^2);

% Plotting exponential fitting function
plot(x, y_exponential, 'r', 'LineWidth', 2);

% Question 2.4: Print sum of squared errors
fprintf('Sum of Squared Errors for Linear Fitting: %.4f\n', soe1);
fprintf('Sum of Squared Errors for Exponential Fitting: %.4f\n', soe2);

% Commenting on choice of best fitting function
% Based on the comparison of sum of squared errors, the fitting function with the lower value
% is typically chosen as the best fitting function. The choice may also depend on the application
% and the context of the data.

