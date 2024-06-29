% 1a. Solving a system equation
% solve system of linear equations of three variables

clc, clear, close all

syms x y z w;
eq1 = x+z+2*w == 6;
eq2 = y-2*z == -3;
eq3 = x+2*y - z == -2;
eq4 = -2*w + 2*x + y + 3*z == 0;

% The output should be: x, y, z, w.
[x y z w] = solve(eq1,eq2,eq3,eq4)
