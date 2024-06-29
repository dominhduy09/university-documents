% Compute the integral of exp(-x) from 0 to 1
clear all; close all; clc;
% Symbolic
syms x
fun = exp(-x);
q = int(fun,[0 1])
% Generated Data with Trapezoid method
del_x = 0.0001;
x_vec = 0:del_x:1;
func = exp(-x_vec);
q_Int = del_x*sum(func)
q_Int = trapz(x_vec,func)