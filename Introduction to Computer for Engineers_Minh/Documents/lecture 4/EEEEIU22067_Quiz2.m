clear all
close all
clc
x = 0.5;
eps = 0.0002;

S = 0;
term = x;
k = 1;

while abs(term) > eps
    S = S + term;
    k = k + 1;
    term = (-1)^(k+1) * (x^k) / k;
end

approximation = S;

real_value = log(x);
error = abs(real_value - approximation);

fprintf('Approximation: %.4f\n', approximation);
fprintf('Real Value: %.4f\n', real_value);
fprintf('Error: %.4f\n', error);
