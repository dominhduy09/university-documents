% This sub-function code is to represent the rectangular function
% rect(t) is 1/T if -T/2 <= t <= T/2 and, otherwise, is 0.
function result = rect(t,T)
    result = 1/T*((t>=-T/2)&(t <= T/2));
end