% Question 3
clear all;
clc;
N = input('Enter an integer number: ');

for i = 1 : N
    for j = 1 : (N+1)
        A(i,j) = i^(j-1);
    end
end
disp(A);