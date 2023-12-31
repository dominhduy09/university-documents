% Let users type the value of a and b
% Use Sub-functions and draw one Figure with 
% two plots of symbolic and generated functions

% Symbolic
syms x
a = input('The value of a is  ');
b = input('The value of b is  ');
f_x = func_example(x);
 
% Generating Datas
x_vec = -5:0.01:5;
fx_vec = func_example(x_vec)
 
figure
fplot(x,f_x)
hold on
plot(x_vec,fx_vec,'x')

