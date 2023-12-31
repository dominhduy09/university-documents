% Prove 1/2 + 1/2^2 + ...+ 1/2^n = 1- 1/2^n
clc; clear all; close all;

n = input('The value of n is ');
x_vec = 1:n;
LHS = sum(0.5.^x_vec);
RHS = 1-0.5^n;
fprintf('The LHS is %4.2f \n', LHS)
fprintf('The RHS is %4.2f \n', RHS)

