% Do the example 4 in Lecture 4.
clc; clear all; close all;
x_vec = 0:0.01:4;
N=10;
k= 0:N;

f_x_vec = zeros(1,length(x_vec));
for ind = 1:length(x_vec)
    x = x_vec(ind);
    f_x = (4./pi)*sum(sin(x.*(2.*k+1))./(2.*k+1));
    f_x_vec(ind) = f_x;
end
plot(x_vec,f_x_vec)
