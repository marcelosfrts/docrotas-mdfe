import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.server.mdfe.MountCondutor;
import com.server.mdfe.MountEmit;
import com.server.mdfe.MountEnderEmit;
import com.server.mdfe.MountIde;
import com.server.mdfe.MountInfAntt;
import com.server.mdfe.MountInfCTe;
import com.server.mdfe.MountInfCiot;
import com.server.mdfe.MountInfDoc;
import com.server.mdfe.MountInfMdfe;
import com.server.mdfe.MountInfModal;
import com.server.mdfe.MountInfMunCarrega;
import com.server.mdfe.MountInfMunDescarga;
import com.server.mdfe.MountInfResp;
import com.server.mdfe.MountInfSeg;
import com.server.mdfe.MountMdfe;
import com.server.mdfe.MountMdfeProc;
import com.server.mdfe.MountRodo;
import com.server.mdfe.MountSeg;
import com.server.mdfe.MountTot;
import com.server.mdfe.MountVeicTracao;
import com.server.utils.FormatUtils;
import com.server.utils.XmlUtils;

public class testXMLOutput {
	private MountMdfeProc mountMdfeProc;
	private MountMdfe mountMdfe;
	private MountInfMdfe mountInfMdfe;
	private MountIde mountIde;
	private MountInfMunCarrega mountInfMunCarrega;
	private MountEmit mountEmit;
	private MountEnderEmit mountEnderEmit;
	private MountInfModal mountInfModal;
	private MountRodo mountRodo;
	private MountInfAntt mountInfAntt;
	private MountInfCiot mountInfCiot;
	private MountVeicTracao mountVeicTracao;
	private MountCondutor mountCondutor;
	private MountInfDoc mountInfDoc;
	private MountInfMunDescarga mountInfMunDescarga;
	private MountInfCTe mountInfCTe;
	private MountSeg mountSeg;
	private MountInfResp mountInfResp;
	private MountInfSeg mountInfSeg;
	private MountTot mountTot;
	
	@Before
	public void setUp() {
		//tag ide
		mountIde = new MountIde();
		mountIde.setcUF(35);
		mountIde.setTpAmb(2);
		mountIde.setTpEmit(1);
		mountIde.setTpTransp(1);
		mountIde.setMod(58);
		mountIde.setSerie(1);
		mountIde.setnMDF(3741);
		mountIde.setcMDF(23161848L);
		mountIde.setcDV(3);
		mountIde.setModal(1);
		mountIde.setDhEmi(FormatUtils.DateXMLFormat(new Date()));
		mountIde.setTpEmis(1);
		mountIde.setProcEmi(0);
		mountIde.setVerProc("1.5.3");
		mountIde.setUFIni("SP");
		mountIde.setUFFim("MG");
		
		//tag infMunCarrega
		mountInfMunCarrega = new MountInfMunCarrega();
		mountInfMunCarrega.setcMunCarrega("3550308");
		mountInfMunCarrega.setxMunCarrega("SAO PAULO");
		
		mountIde.setMountInfMunCarrega(mountInfMunCarrega);
		mountIde.setDhIniViagem(FormatUtils.DateXMLFormat(new Date()));
		
		//tag emit
		mountEmit = new MountEmit();
		mountEmit.setCnpj("03876961000233");
		mountEmit.setIe("143263811113");
		mountEmit.setxNome("CAMPOS E BUENO TRANSPORTES LTDA - EPP");
		mountEmit.setxFant("IDEIA DE MINAS TRANSPORTES");
		
		//tag enderEmit
		mountEnderEmit = new MountEnderEmit();
		mountEnderEmit.setxLgr("RUA SOLDADO ARISTIDES GOUVEIA");
		mountEnderEmit.setNro(374L);
		mountEnderEmit.setxBairro("PARQUE NOVO MUNDO");
		mountEnderEmit.setcMun(3550308L);
		mountEnderEmit.setxMun("SAO PAULO");
		mountEnderEmit.setCep("02188090");
		mountEnderEmit.setUf("SP");
		mountEnderEmit.setFone("1138046933");
		
		mountEmit.setMountEnderEmit(mountEnderEmit);
		
		//tag infModal
		mountInfModal = new MountInfModal();
		mountInfModal.setVersaoModal("3.00");
		
		//tag rodo
		mountRodo = new MountRodo();
		
		//tag infANTT
		mountInfAntt = new MountInfAntt();
		mountInfAntt.setRntrc("46881758");
		
		//tag infCIOT
		mountInfCiot = new MountInfCiot();
		mountInfCiot.setCiot("012345678912");
		mountInfCiot.setCnpj("01405106000138");
		
		mountInfAntt.setMountInfCiot(mountInfCiot);
		
		//tag veicTracao
		mountVeicTracao = new MountVeicTracao();
		mountVeicTracao.setPlaca("JAH5522");
		mountVeicTracao.setRenavam("475626605");
		mountVeicTracao.setTara(16000L);
		mountVeicTracao.setCapkg(32000L);
		
		//tag condutor
		mountCondutor = new MountCondutor();
		mountCondutor.setxNome("LUIZ GUSTAVO DE SOUZA NUNES");
		mountCondutor.setCpf("11322031630");
		
		mountVeicTracao.setMountCondutor(mountCondutor);
		mountVeicTracao.setTpRod("03");
		mountVeicTracao.setTpCar("02");
		mountVeicTracao.setUf("RS");
		
		mountRodo.setMountInfAntt(mountInfAntt);
		mountRodo.setMountInfVeicTracao(mountVeicTracao);
		
		mountInfModal.setMountRodo(mountRodo);
		
		//tag infDoc
		mountInfDoc = new MountInfDoc();
		
		//tag infMunDescarga
		mountInfMunDescarga = new MountInfMunDescarga();
		mountInfMunDescarga.setcMunDescarga("3170206");
		mountInfMunDescarga.setxMunDescarga("UBERLANDIA");
				
		//tag infCTe >> N:N
		mountInfCTe = new MountInfCTe();
		mountInfCTe.setChCTe("35180303876961000233570010000796961000799182");
		mountInfMunDescarga.setMountInfCTe(mountInfCTe);
		
		mountInfDoc.setMountInfMunDescarga(mountInfMunDescarga);
		
		//tag seg
		mountSeg = new MountSeg();
		
		//tag infResp
		mountInfResp = new MountInfResp();
		mountInfResp.setRespSeg(1);
		mountInfResp.setCnpj("03876961000233");
		mountSeg.setMountInfResp(mountInfResp);
		
		//tag infSeg
		mountInfSeg = new MountInfSeg();
		mountInfSeg.setxSeg("PORTO SEGURO");
		mountInfSeg.setCnpj("61198164000160");
		mountSeg.setMountInfSeg(mountInfSeg);
		
		mountSeg.setnApol("0655067051");
		mountSeg.setnAver("41217630165");
		
		//tag tot
		mountTot = new MountTot();
		mountTot.setqCTe(66);
		mountTot.setvCarga(new BigDecimal("137900.93"));
		mountTot.setcUnid("01");
		mountTot.setqCarga(new BigDecimal("8860.0000"));
		
		//tag infMdfe
		mountInfMdfe = new MountInfMdfe();
		mountInfMdfe.setId("MDFe35180303876961000233580010000037411231618483");
		mountInfMdfe.setMountIde(mountIde);
		mountInfMdfe.setMountEmit(mountEmit);
		mountInfMdfe.setMountInfModal(mountInfModal);
		mountInfMdfe.setMountInfDoc(mountInfDoc);
		mountInfMdfe.setMountSeg(mountSeg);
		mountInfMdfe.setMountTot(mountTot);
		
		//tag mdfe
		mountMdfe = new MountMdfe(mountInfMdfe);
		mountMdfeProc = new MountMdfeProc(mountMdfe);
	}
	
	@After
	public void tearDown() {
		mountMdfeProc = null;
	}
	
	@Test
	public void testeMountMdfe() throws JAXBException, XMLStreamException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(MountMdfeProc.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		marshaller.marshal(mountMdfeProc, new File("test.xml"));
		marshaller.marshal(mountMdfeProc, System.out);
		
		InputStream input = getClass().getResourceAsStream("/schema-mdfe-300/enviMDFe_v3.00.xsd");
		String arqXsd = "/schema-mdfe-300/enviMDFe_v3.00.xsd";
		boolean validou = XmlUtils.validarXml(mountMdfeProc.toString(), arqXsd);
		System.out.print(validou);
	}

}
