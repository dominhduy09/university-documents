% Generate a random matrix and compute the squared norm of the matrix
% x = [x11 x12; x21 x22] and ||x||^2 = x11^2 + x12^2 + x21^2 + x22^2

clear all; close all; clc; 

n = input('Number of row is ')
m = input('Number of column is ')
% Generate a random matrix n x m
A = randn(n,m);

% Compute the squared norm of the matrix
% Double-Loop
norm1 = 0;
for i=1:n
    for j=1:m
        norm1 = norm1 + abs(A(i,j))^2;
    end
end
norm1

% Matrix-based Method
norm2 = sum(sum(abs(A).^2))

