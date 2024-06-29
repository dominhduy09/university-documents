% Bai_1

% a using symbolic.
clear, clc, close all
syms x2 y2 z2 w2


one = x2 + y2 + z2 + w2 == 13;
two = 2*x2 + 3*y2 - w2 == -1;
three = -3*x2 + 4*y2 + z2 + 2*w2 == 10;
four = x2 + 2*y2 - z2 + w2 == 1;

[x2 y2 z2 w2] = solve(one,two,three,four);

% b using matrices.
A=[1 1 1 1; 2 3 0 -1; -3 4 1 2; 1 2 -1 1];
B=[13; -1; 10; 1];
C=inv(A)*B;

fprintf('By using matrices \r')
fprintf('x1= %4.2f \r',C(1))
fprintf('y1= %4.2f \r',C(2))
fprintf('z1= %4.2f \r',C(3))
fprintf('w1= %4.2f \r',C(4))
fprintf('By using sympolic \r')
fprintf('x2= %4.2f \r',double(y2))
fprintf('y2= %4.2f \r',double(z2))
fprintf('z2= %4.2f \r',double(w2))
fprintf('w2= %4.2f \r',double(x2))






