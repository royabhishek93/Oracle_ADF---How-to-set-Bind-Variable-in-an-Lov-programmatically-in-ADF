package com.abhishek.view;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.OperationBinding;

public class Bean {
    private RichInputText inputTextBind;
    private Integer deptId;

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public Bean() {
    }
    public OperationBinding getBindings(String binding){
        return BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(binding);
    }
 /*   public String setLovBindVarAL() {
        Object object = inputTextBind.getValue();
       
        return null;
    }
*/
    public void setInputTextBind(RichInputText inputTextBind) {
        this.inputTextBind = inputTextBind;
    }

    public RichInputText getInputTextBind() {
        return inputTextBind;
    }

    public void setLovBindVarAL(ActionEvent actionEvent) {
        Object object = inputTextBind.getValue();
        OperationBinding binding = getBindings("setBindVarAndExceuteLov");
        System.out.println("deptId**"+deptId);
        binding.getParamsMap().put("deptId", deptId);
        binding.execute();
    }
}
