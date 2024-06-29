clear all; close all; clc;

clc; clear all; close all;
% Cach 1
A = [1 -1 -1;4 6 0; 4 0 12]
B = [0; 12; 12]
ketqua = A\B
% Cach 2
A_1 = [4 6 0; 4 0 12; 4+(6*12)/(6+12) 0 0 ]
B_2 = [12; 12; 12]
ketqua = A_1\B_2