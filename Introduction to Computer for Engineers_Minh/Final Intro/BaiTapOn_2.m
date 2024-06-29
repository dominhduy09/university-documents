% 1b. Consider the following Normal
% Distribution and write a script to
% solve the corresponding integral
clc, clear, close all

syms x
a = 5;
o = 1;
u = 0;
y = (1 / (sqrt(2*pi*o^2))) * exp((-(x-u)^2) / (2*o^2))

% Convert the result to double
d = double(int(y,-a,a))
