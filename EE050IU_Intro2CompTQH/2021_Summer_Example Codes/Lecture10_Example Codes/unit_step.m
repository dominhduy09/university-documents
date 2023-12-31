% This sub-function code is to represent the unit-step function
% u(t) is 1 if t >=0 and, otherwise, is 0.
function result = unit_step(t)
    result = 1.*(t>=0);
end