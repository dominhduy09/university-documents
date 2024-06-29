clear all; close all; clc;
% Equation System 1
A1 = [2 1 0; 1 5 -1; 1 -2 4];
b1 = [4;8;9];
x1 = A1\b1;
% Equation System 2
A2 = [4 3 0; 2 2 -2; 5 3 1];
B2 = [4 0 -2]';
x2 = A2\B2
% Equation System 3
A3 = [1 -2 -3; 3 2 -1; 0 3 -1];
b3 = [0 0 0];
x3 = A3\b3
% Equation System 4
A4=[16 16 17;-14 17 -3;-5 -11 -18];
b4=[10;75;43];
x4=A4\b4