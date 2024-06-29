% 1c, likely
clc, clear, close all

syms x
a = 5;
b = 7;

% Calculate the integral
y = a^x + b^(1-x)
d = int(y,0,1)

