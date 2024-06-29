% Question 2
% a. Create a row vector that goes equal steps from -5 to 5 containing 50 components
a = linspace(-5,5,50);

% b. Create a row vector spanning the range from 0 to 2π, containing 100 equally spaced components,
% so that the first value is 0, and the last value is 2π
b = linspace(0, 2*pi, 100);

% c. Create a column vector with 50 values which are sine of equally spaced components ranging from 0 to π
c = sin(linspace(0, pi, 50))';

% d. Create a 10x10 matrix, so that the odd columns should contain values 3, and the even columns, values 0
d = zeros(10);
d(:, 1:2:end) = 3;
