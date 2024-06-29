clear all;
close all;
clc;

function [a, b] = swapValues(a, b)
    temp = a;
    a = b;
    b = temp;
end
