% demo - my first script
clear all; %clear all var in workspace
close all; %close all figures
clc; %clear the content of cmd window

%% Variable declaration
% scalar - Ocatave does not distinguish between integer
% they just asign with varible name
%integer
##var_int =10;
##%binary
##var_bin =0;
##% real
##var_real = 10.2;

% array (vector) vs. scalar
% vector - assign row and col vector into variable
##vec1_row = [10.2 2.1]
##vec2_col = [1;2;3;4;5]
##disp("my assignment");
##size(vec1_row)
##size(vec2_col)
##
##length(vec1_row)
##length(vec2_col)
## disp("Nguyễn Đào Anh Khôi");
##
## disp(" operation transpose");
## vec2_col'
## size(vec2_col')
disp(" COnventional Math, Operation");
 vec3 = [1 2 3];
 vec4 = [4 5 6];
 %compute the sum of two vector and assign
 %its value into a new vector
 disp('addition, sub& assignment')
 vec5= vec3 + vec4
 vec6= vec4 - vec3
 disp('product dot, cross& assignment')
%since dot product will return a scalar. then
%var_dot is a scalar variable
var_dot = dot(vec3, vec4)
%cross product will return a vector - assign to
vec7 = cross(vec3,vec4)
 disp("Nguyễn Đào Anh Khôi");







