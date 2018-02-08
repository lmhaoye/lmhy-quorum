package com.lmhy.bcos.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class SOrder extends Contract {
    private static final String BINARY = "606060405234156200001057600080fd5b604051620016ba380380620016ba83398101604052808051820191906020018051919060200180519190602001805191506040905080519081016040528481526020810184905260038151819080516200006f92916020019062000196565b5060208201516001909101555060a06040519081016040528085815260200183600160a060020a0316815260200182600160a060020a031681526020014281526020018481525060086000808152602001908152602001600020600082015181908051620000e292916020019062000196565b506020820151600182018054600160a060020a031916600160a060020a03929092169190911790556040820151600282018054600160a060020a031916600160a060020a0392909216919091179055606082015181600301556080820151600491909101555060058054600190810190915560008054600160a060020a03948516600160a060020a031991821617909155815492909316919092161760a060020a60ff02191690555050426002556200023b565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620001d957805160ff191683800117855562000209565b8280016001018555821562000209579182015b8281111562000209578251825591602001919060010190620001ec565b50620002179291506200021b565b5090565b6200023891905b8082111562000217576000815560010162000222565b90565b61146f806200024b6000396000f3006060604052600436106100f05763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631315198181146100f5578063229ba10d1461012457806335551aec14610266578063370158ea146102c9578063452b07f01461036c578063498d45861461038257806361dcd7ab1461043157806371cf5c7a1461044457806377dfd085146104f1578063808ec6f614610504578063bb4d09f214610517578063c19d93fb14610568578063c47d25861461059f578063d5ce3389146105f0578063ee69796714610603578063fb117433146106ca578063ff11364c146106dd575b600080fd5b341561010057600080fd5b610108610748565b604051600160a060020a03909116815260200160405180910390f35b341561012f57600080fd5b61013a600435610757565b604051600160a060020a038086166040830152841660608201526080810183905260a0810182905260c08082528754600260001961010060018416150201909116049082018190528190602082019060e08301908a9080156101dd5780601f106101b2576101008083540402835291602001916101dd565b820191906000526020600020905b8154815290600101906020018083116101c057829003601f168201915b50508381038252885460026000196101006001841615020190911604808252602090910190899080156102515780601f1061022657610100808354040283529160200191610251565b820191906000526020600020905b81548152906001019060200180831161023457829003601f168201915b50509850505050505050505060405180910390f35b341561027157600080fd5b6102b760046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061079095505050505050565b60405190815260200160405180910390f35b34156102d457600080fd5b6102dc61098e565b604051602081018290526040808252835460026000196101006001841615020190911604908201819052819060608201908590801561035c5780601f106103315761010080835404028352916020019161035c565b820191906000526020600020905b81548152906001019060200180831161033f57829003601f168201915b5050935050505060405180910390f35b341561037757600080fd5b61013a600435610997565b341561038d57600080fd5b61042f60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965050600160a060020a038535811695602081013590911694506040013592506109d0915050565b005b341561043c57600080fd5b6102b7610abc565b341561044f57600080fd5b61042f60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965050600160a060020a03853581169560208101359091169450604001359250610ac2915050565b34156104fc57600080fd5b6102b7610ccb565b341561050f57600080fd5b6102b7610cd1565b341561052257600080fd5b6102b760046024813581810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650610cd795505050505050565b341561057357600080fd5b61057b610f71565b6040518082600281111561058b57fe5b60ff16815260200191505060405180910390f35b34156105aa57600080fd5b6102b760046024813581810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650610f9295505050505050565b34156105fb57600080fd5b61010861122c565b341561060e57600080fd5b61061960043561123b565b604051600160a060020a03808616602083015284166040820152606081018390526080810182905260a0808252865460026000196101006001841615020190911604908201819052819060c0820190889080156106b75780601f1061068c576101008083540402835291602001916106b7565b820191906000526020600020905b81548152906001019060200180831161069a57829003601f168201915b5050965050505050505060405180910390f35b34156106d557600080fd5b6102b7611270565b34156106e857600080fd5b61042f60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965050600160a060020a03853581169560208101359091169450604001359250611276915050565b600154600160a060020a031681565b600a60205260009081526040902060028101546003820154600483015460058401546001850193600160a060020a039081169316919086565b600080600061079d611343565b600091505b6005548260ff16101561098557600860008360ff16815260200190815260200160002060a06040519081016040529081600082018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561086a5780601f1061083f5761010080835404028352916020019161086a565b820191906000526020600020905b81548152906001019060200180831161084d57829003601f168201915b50505091835250506001820154600160a060020a039081166020830152600283015416604080830191909152600383015460608301526004909201546080909101529091508590518082805190602001908083835b602083106108de5780518252601f1990920191602091820191016108bf565b6001836020036101000a038019825116818451161790925250505091909101925060409150505190819003902081516040518082805190602001908083835b6020831061093c5780518252601f19909201916020918201910161091d565b6001836020036101000a0380198251168184511617909252505050919091019250604091505051908190039020141561097a578160ff169250610985565b6001909101906107a2565b50909392505050565b60045460039082565b600960205260009081526040902060028101546003820154600483015460058401546001850193600160a060020a039081169316919086565b60c060405190810160409081528682526020808301879052600160a060020a038087168385015285166060840152608083018490524260a084015260078054600181019091556000908152600a90915220815181908051610a35929160200190611379565b50602082015181600101908051610a50929160200190611379565b506040820151600282018054600160a060020a031916600160a060020a03929092169190911790556060820151600382018054600160a060020a031916600160a060020a03929092169190911790556080820151816004015560a0820151600590910155505050505050565b60025481565b6000610acc611343565b610ad587610790565b6000818152600860205260409081902091935060a090519081016040529081600082018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b8c5780601f10610b6157610100808354040283529160200191610b8c565b820191906000526020600020905b815481529060010190602001808311610b6f57829003601f168201915b50505091835250506001820154600160a060020a039081166020830152600283015416604082015260038201546060820152600490910154608091820152909150810151831115610bdc57610cc2565b60c0604051908101604090815287825260208083018a9052600160a060020a038089168385015287166060840152608083018690524260a084015260068054600181019091556000908152600990915220815181908051610c41929160200190611379565b50602082015181600101908051610c5c929160200190611379565b506040820151600282018054600160a060020a031916600160a060020a03929092169190911790556060820151600382018054600160a060020a031916600160a060020a03929092169190911790556080820151816004015560a0820151600590910155505b50505050505050565b60055481565b60075481565b6000806000610ce46113f7565b600091505b6007548260ff16101561098557600a60008360ff16815260200190815260200160002060c06040519081016040529081600082018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610db15780601f10610d8657610100808354040283529160200191610db1565b820191906000526020600020905b815481529060010190602001808311610d9457829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e535780601f10610e2857610100808354040283529160200191610e53565b820191906000526020600020905b815481529060010190602001808311610e3657829003601f168201915b50505091835250506002820154600160a060020a039081166020830152600383015416604080830191909152600483015460608301526005909201546080909101529091508590518082805190602001908083835b60208310610ec75780518252601f199092019160209182019101610ea8565b6001836020036101000a038019825116818451161790925250505091909101925060409150505190819003902060208201516040518082805190602001908083835b60208310610f285780518252601f199092019160209182019101610f09565b6001836020036101000a03801982511681845116179092525050509190910192506040915050519081900390201415610f66578160ff169250610985565b600190910190610ce9565b60015474010000000000000000000000000000000000000000900460ff1681565b6000806000610f9f6113f7565b600091505b6006548260ff16101561098557600960008360ff16815260200190815260200160002060c06040519081016040529081600082018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561106c5780601f106110415761010080835404028352916020019161106c565b820191906000526020600020905b81548152906001019060200180831161104f57829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561110e5780601f106110e35761010080835404028352916020019161110e565b820191906000526020600020905b8154815290600101906020018083116110f157829003601f168201915b50505091835250506002820154600160a060020a039081166020830152600383015416604080830191909152600483015460608301526005909201546080909101529091508590518082805190602001908083835b602083106111825780518252601f199092019160209182019101611163565b6001836020036101000a038019825116818451161790925250505091909101925060409150505190819003902060208201516040518082805190602001908083835b602083106111e35780518252601f1990920191602091820191016111c4565b6001836020036101000a03801982511681845116179092525050509190910192506040915050519081900390201415611221578160ff169250610985565b600190910190610fa4565b600054600160a060020a031681565b60086020526000908152604090206001810154600282015460038301546004840154600160a060020a03938416939092169185565b60065481565b60a06040519081016040908152858252600160a060020a038086166020808501919091529085168284015242606084015260808301849052600580546001810190915560009081526008909152208151819080516112d8929160200190611379565b506020820151600182018054600160a060020a031916600160a060020a03929092169190911790556040820151600282018054600160a060020a031916600160a060020a03929092169190911790556060820151816003015560808201516004909101555050505050565b60a060405190810160405280611357611414565b8152600060208201819052604082018190526060820181905260809091015290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106113ba57805160ff19168380011785556113e7565b828001600101855582156113e7579182015b828111156113e75782518255916020019190600101906113cc565b506113f3929150611426565b5090565b60c06040519081016040528061140b611414565b81526020016113575b60206040519081016040526000815290565b61144091905b808211156113f3576000815560010161142c565b905600a165627a7a72305820debfcd28b9beaed1b6f4600b73a10662005bf5bf4a888f23364a2d1bd911b3590029";

    protected SOrder(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SOrder(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> to() {
        Function function = new Function("to", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple6<String, String, String, String, BigInteger, BigInteger>> rmap(BigInteger param0) {
        final Function function = new Function("rmap", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<String, String, String, String, BigInteger, BigInteger>>(
                new Callable<Tuple6<String, String, String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple6<String, String, String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple6<String, String, String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getCder(String _no) {
        Function function = new Function("getCder", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_no)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple2<String, BigInteger>> info() {
        final Function function = new Function("info", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<Tuple6<String, String, String, String, BigInteger, BigInteger>> lmap(BigInteger param0) {
        final Function function = new Function("lmap", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<String, String, String, String, BigInteger, BigInteger>>(
                new Callable<Tuple6<String, String, String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple6<String, String, String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple6<String, String, String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> repayFun(String _cNo, String _no, String _from, String _to, BigInteger _fee) {
        Function function = new Function(
                "repayFun", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_cNo), 
                new org.web3j.abi.datatypes.Utf8String(_no), 
                new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> createTime() {
        Function function = new Function("createTime", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> loadFun(String _cNo, String _no, String _from, String _to, BigInteger _fee) {
        Function function = new Function(
                "loadFun", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_cNo), 
                new org.web3j.abi.datatypes.Utf8String(_no), 
                new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> cmapSize() {
        Function function = new Function("cmapSize", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> rmapSize() {
        Function function = new Function("rmapSize", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getRepay(String _no) {
        Function function = new Function("getRepay", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_no)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> state() {
        Function function = new Function("state", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getLoan(String _no) {
        Function function = new Function("getLoan", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_no)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> from() {
        Function function = new Function("from", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple5<String, String, String, BigInteger, BigInteger>> cmap(BigInteger param0) {
        final Function function = new Function("cmap", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple5<String, String, String, BigInteger, BigInteger>>(
                new Callable<Tuple5<String, String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<String, String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple5<String, String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> lmapSize() {
        Function function = new Function("lmapSize", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> splitOrder(String _no, String _from, String _to, BigInteger _fee) {
        Function function = new Function(
                "splitOrder", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_no), 
                new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<SOrder> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _code, BigInteger _fee, String _from, String _to) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_code), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee), 
                new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to)));
        return deployRemoteCall(SOrder.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<SOrder> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _code, BigInteger _fee, String _from, String _to) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_code), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee), 
                new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to)));
        return deployRemoteCall(SOrder.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static SOrder load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SOrder(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SOrder load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SOrder(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
