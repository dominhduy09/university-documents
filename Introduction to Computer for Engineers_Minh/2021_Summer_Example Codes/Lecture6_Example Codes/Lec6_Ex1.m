clear all; close all; clc;

% Slide 7 in Lecture 6.
% k1 = [1; 0; -2];
% k2 = [0; 3; 1];
% x = [];
% for k = [k1,k2]
%     x = [x, 3.0 + 0.1*k];
% end

% Slide 8 in Lecture 6
for k = [3, 7, 10]
    x(k) = 3 + 0.1*k;
    disp(x);
end