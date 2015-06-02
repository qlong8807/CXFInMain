package server.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public AuthInterceptor() {
		// �������ڵ��÷���֮ǰ����SOAP��Ϣ
		super(Phase.PRE_INVOKE);
	}

	/**
	 * @Description: ����������
	 * @param msg
	 *            �����ص���SOAP��Ϣ
	 * @throws Fault
	 */
	@Override
	public void handleMessage(SoapMessage msg) throws Fault {

		System.out.println("=====�Զ���������=======");

		QName qName = (QName) msg.get(SoapMessage.WSDL_OPERATION);
		String methodName = qName.getLocalPart();
		System.out.println("----���ýӿ�--->:" + methodName);

		// ��ȡSOAP��Ϣ��Header
		List<Header> headers = msg.getHeaders();
		// ���û��Header
		if (headers == null || headers.size() < 1) {
			throw new Fault(new IllegalArgumentException("û��Header,������ʵʩ����"));
		}
		// ��ȡHeaderЯ�����û���������Ϣ
		Header firstHeader = headers.get(0);
		Element ele = (Element) firstHeader.getObject();

		NodeList userIdEle = ele.getElementsByTagName("userId");
		NodeList userPassEle = ele.getElementsByTagName("userPass");

		if (userIdEle.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("�û�Id��ʽ����"));
		}

		if (userPassEle.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("�û������ʽ����"));
		}

		// ��ȡԪ�ص��ı�����
		String userId = userIdEle.item(0).getTextContent();
		String userPass = userPassEle.item(0).getTextContent();

		if (!userId.equals("zyl") || !userPass.equals("123456")) {
			throw new Fault(new IllegalArgumentException("�û������벻��ȷ"));
		}
		System.out.println("HeaderУ����ȷ�����������У�����");
	}

}
