%Ex3_1 Swap two values
function [ a , b ] = swap ( a , b )
% The function swap receives two values, swaps them
    temp = a;
    a = b;
    b = temp;
end
