package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Documento;
import br.ufc.qxd.agtcc.repository.DocumentoRepository;
import br.ufc.qxd.agtcc.service.interfaces.IDocumentoService;


@Service
public class DocumentoService implements IDocumentoService {

	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Override
	public Documento save(Documento documento) {
		return documentoRepository.save(documento);
	}

	@Override
	public Documento update(Documento documento) {
		return documentoRepository.save(documento);
	}

	@Override
	public void delete(Long id) {
		documentoRepository.delete(id);
	}

	@Override
	public List<Documento> findAll() {
		return documentoRepository.findAll();
	}

	@Override
	public Documento findOne(Long id) {
		return documentoRepository.findOne(id);
	}

}
