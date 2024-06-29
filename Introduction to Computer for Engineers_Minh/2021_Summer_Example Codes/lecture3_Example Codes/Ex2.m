% Symbolic Function & Generating Datas
clc; clear all; close all;
% Symbolic
syms x;
f_x = exp(-0.5.*x).*sin(5.*x);
% Generating Datas
x_vec = -5:0.01:5;
fx_vec = exp(-0.6*x_vec).*sin(5.*x_vec);

figure
fplot(x,f_x)
hold on
plot(x_vec,fx_vec)

