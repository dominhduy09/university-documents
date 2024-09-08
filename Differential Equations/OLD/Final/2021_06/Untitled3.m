clc;
clear all;
close all;

syms A B C D E x t y

y = -x^3/210+x^2/4
y_d = diff(y,x)
y_dd = diff(y_d,x)
y_ddd = diff(y_dd,x)

simplify(y_ddd+10*y_dd/x+8*y_d/x^2)