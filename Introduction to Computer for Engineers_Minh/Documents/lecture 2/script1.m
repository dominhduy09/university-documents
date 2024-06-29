% demo - my first script
clear all; %clear all var in workspace
close all; %close all figures
clc; %clear the content of cmd window

%output to cmd window - hello string
disp("Hello - my first script")
disp("Call a function in a script")
function out = mysecondfunc(a,b)
  out = (a*b+1);
end
