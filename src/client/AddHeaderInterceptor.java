package client;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AddHeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	private String userId;
	private String userPass;

	public AddHeaderInterceptor(String userId, String userPass) {
		super(Phase.PREPARE_SEND);
		this.userId = userId;
		this.userPass = userPass;
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault {

		List<Header> headers = msg.getHeaders();
		// ����Document����
		Document doc = DOMUtils.createDocument();
		Element ele = doc.createElement("authHeader");
		// ���÷�������Head��Ϣ���û�����
		Element eleId = doc.createElement("userId");
		eleId.setTextContent(userId);
		Element elePass = doc.createElement("userPass");
		elePass.setTextContent(userPass);

		ele.appendChild(eleId);
		ele.appendChild(elePass);
		/**
		 * ���ɵ�XML�ĵ� <authHeader> <userId>lzw</userId>
		 * <userPass>123456</userPass> </authHeader>
		 */
		headers.add(new Header(new QName(""), ele));
	}

}
