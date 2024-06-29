% Array and Matrices
clc; clear all; close all; 

% Dealing with complex vector
z = [i; 1+2i; 1-i]
z'      % transpose with conjugate for complex numbers
z.'     % transpose without conjugate for complex numbers
conj(z) % not transpose but conjugate for complex numbers

% Take or replace elements from matrices 
x = zeros(2,3)
x = ones(2,3)

x = 1:2:20
x(1:2:length(x))
fliplr(x)
x([1, 5])



