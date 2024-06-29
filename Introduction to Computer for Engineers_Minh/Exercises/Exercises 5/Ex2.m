% Set display format
format short g;

% a. Create a vector t with 51 equidistant elements from -25 to 25
t = linspace(-25, 25, 51)';
disp('Vector t:');
disp(t);

% b. Calculate the vector x = t^2
x = t.^2;
disp('Vector x = t^2:');
disp(x);

% c. Calculate the vector y = t^3 in reverse order
y = flip(t.^3);
disp('Vector y = t^3 in reverse order:');
disp(y);

% d. Calculate the sum of all even values in vector x
even_values_x = x(mod(x, 2) == 0);
sum_even_x = sum(even_values_x);
disp(['Sum of even values in vector x: ' num2str(sum_even_x)]);

% e. Calculate the sum of all positive values in vector y
positive_values_y = y(y > 0);
sum_positive_y = sum(positive_values_y);
disp(['Sum of positive values in vector y: ' num2str(sum_positive_y)]);

