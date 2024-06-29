clear all
close all
clc
N=3;
sequence = [];
for i=1:N;
  for j=i:N;
    sequence = [sequence; i j];
    end
  endfor
  %DIsplay the squences
 disp(sequence);
