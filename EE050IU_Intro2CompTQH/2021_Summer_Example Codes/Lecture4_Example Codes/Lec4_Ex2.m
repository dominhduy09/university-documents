% Test the convergence
clc; clear all; close all;
% Code the RHS 
N_vec = 1:15; f_N_vec = zeros(1,length(N_vec));
for ind = 1:length(N_vec)
    N = N_vec(ind);
    f_N = lec4_func_ex2(N);
    f_N_vec(ind) = f_N;
end
% Code the LHS
y_LHS = pi*ones(1,length(N_vec));
% Plot
figure
plot(N_vec, f_N_vec)
hold on; grid on;
plot(N_vec, y_LHS,'x');



