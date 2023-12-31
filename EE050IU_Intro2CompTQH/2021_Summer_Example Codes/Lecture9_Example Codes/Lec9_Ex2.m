% Compute the integral of x*exp(-x) from 0 to 1
clear all; close all; clc;
% Symbolic Method
syms x;
a = x*exp(-x);
f = double(int(a,0,1))
% Trapezoid Method
del_x = 0.0001;
x_vec = 0:del_x:1;
func = x_vec.*exp(-x_vec);
q_Int = trapz(x_vec,func)



