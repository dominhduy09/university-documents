clc;
clear all;
close all;

syms A B C D E x t

x = A*exp(-t)+B*exp(2*t)-3*t/2-1/4
x_d = diff(x,t)
x_dd = diff(x_d,t)


simplify(x_dd - x_d - 2*x)
0.5*(x_d-t)


x = A*exp(-t) + B*exp(2*t)-3*t/2-3/4
y = B*exp(2*t) - (A*exp(-t))/2 - t/2 - 3/4

check_1 = diff(x,t) - 2*y - t
check_2 = diff(y,t) - x - y - 2*t - 1