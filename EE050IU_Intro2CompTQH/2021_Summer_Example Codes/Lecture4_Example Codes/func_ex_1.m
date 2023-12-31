% Write a sub-function to calculate the 
% RMS value and the mean-absolute value

function [rms_val, mean_val] = func_ex_1(x)
   rms_val = sqrt(sum(abs(x).^2)/length(x));
   mean_val = sum(abs(x))/length(x);
end