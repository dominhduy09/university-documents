% Writing a sub-function
clc; clear all; close all

% Symbolic
syms x 
f_x = func_example(x);

% Generating Datas
x_vec = -5:0.01:5;
fx_vec = func_example(x_vec);

figure
fplot(x,f_x)
hold on
plot(x_vec,fx_vec,'x')

