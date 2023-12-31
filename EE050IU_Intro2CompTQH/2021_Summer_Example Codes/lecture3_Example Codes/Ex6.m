clc; clear all; close all;
f = @(x) exp(-0.5*x).*sin(5*x);
fplot(f,[-10,5]);