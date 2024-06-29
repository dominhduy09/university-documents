% Redo Example 2 with the cumsum in sub-function
clc; clear all; close all;
% RHS
N = 10;
y_RHS = lec4_func_ex3(N);
% LHS
y_LHS = pi*ones(1,length(y_RHS));

% Plot
x_axis_vec = 0:N;
figure
plot(x_axis_vec, y_RHS)
hold on; grid on;
plot(x_axis_vec, y_LHS,'x');



