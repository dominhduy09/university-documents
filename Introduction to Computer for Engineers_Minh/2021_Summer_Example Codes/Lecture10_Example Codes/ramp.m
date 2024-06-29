% This sub-function code is to represent the ramp function
% ramp(t) is t if t >=0 and, otherwise, is 0.
function result = ramp(t)
    result = t.*(t>=0);
%     result = t.*unit_step(t);
end