% Use indicator functions to represent a general function
clc; clear all; close all;

% Figure 1
x_vec = -2:0.001:4;
% fx_vec = 2*x_vec.*((x_vec >= 0)&(x_vec < 0.5)) + 1*((x_vec >= 0.5)&(x_vec < 1.5))+ (4-2*x_vec).*((x_vec >= 1.5)&(x_vec < 2));
fx_vec = 2*x_vec.*indi_func(x_vec,0,0.5)+indi_func(x_vec,0.5,1.5)+(4-2*x_vec).*indi_func(x_vec,1.5,2);

% Figure 2 
fx_scaled = 2*fx_vec;

figure
subplot(1,2,1)    % For Figure 1
plot(x_vec, fx_vec,'-b','linewidth',2)
grid on
xlabel('x'); ylabel('f(x)')
title('f(x) versus x')
ylim([0 2])
subplot(1,2,2)    % For Figure 2
plot(x_vec, fx_scaled,'-r','linewidth',2)
grid on
xlabel('x'); ylabel('2*f(x)')
title('2*f(x) versus x')