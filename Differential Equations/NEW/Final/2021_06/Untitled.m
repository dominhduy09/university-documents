clc;
clear all;
close all;

syms A B C D E x

y = A + B*exp(3*x) +C*x*exp(3*x)+x^2*(1/18*x+-1/18)*exp(3*x)
y_d = diff(y,x)
y_dd = diff(y_d,x)
y_ddd = diff(y_dd,x)
y_dddd = diff(y_ddd,x)

y_ddd - 6*y_dd + 9*y_d