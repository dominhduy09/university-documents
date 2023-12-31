% Write a code for computing energy and power of x(t) = exp(-t)*unit_step(t)
% and decide whether x(t) is energy/power signal or not. 

clear all; close all; clc;
% syms t  T
% % x = exp(-t).*unit_step(t);
% x = exp(-t).*heaviside(t);
% E = int(abs(x).^2,-inf,inf)
% P = limit((1/T)*int(abs(x)^2,0,T),T,inf)
fprinf('');

% Write a code for computing energy and power of x(t) = 0.25^n.*unit_step(t)
% and decide whether x(t) is energy/power signal or not. 

clear all; close all; clc;
syms n  T
x = 0.25^n.*heaviside(n);
E =double( int(abs(x).^2,-inf,inf))
P = limit((1/T)*int(abs(x)^2,0,T),T,inf)
fprinf('');