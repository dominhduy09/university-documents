% Compute the indefined integral of a*x^2+bx+c
% the user can type the values of a, b and c.
% and compute the above integral with limit [0, 1] 

clc; clear all; close all;
a = input ('Type a: ');
b = input ('Type b: ');
c = input ('Type c: ');

syms x
A = a*x.^2+b*x+c;
F_x = int(A)
G_x = int(A, 0,1)