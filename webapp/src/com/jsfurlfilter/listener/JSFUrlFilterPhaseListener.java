/**
 * 
 */
package com.jsfurlfilter.listener;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.jsfurlfilter.context.UrlContext;
import com.jsfurlfilter.util.Constants;

/**
 * Checks the lifecycle phases of JSF and executes EL expression present in
 * {@link UrlContext} for a mapped URL during 'RESTORE_VIEW' phase.
 * 
 * @author Ashwin
 * 
 */
public class JSFUrlFilterPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
	}

	@Override
	public void beforePhase(PhaseEvent phaseEvent) {
		if (PhaseId.RESTORE_VIEW.equals(phaseEvent.getPhaseId())) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			UrlContext urlContext = (UrlContext) facesContext
					.getExternalContext().getRequestMap()
					.get(Constants.REQUEST_ATTR_URL_CONTEXT);
			String methodEl = urlContext.getELExecute();

			if (methodEl != null && !"".equals(methodEl)) {
				ELContext elContext = facesContext.getELContext();
				ExpressionFactory expressionFactory = FacesContext
						.getCurrentInstance().getApplication()
						.getExpressionFactory();
				MethodExpression methodExpression = expressionFactory
						.createMethodExpression(elContext, methodEl, null, null);
				methodExpression.invoke(elContext, null);
			}
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return FacesContext.getCurrentInstance().getCurrentPhaseId();
	}

}
